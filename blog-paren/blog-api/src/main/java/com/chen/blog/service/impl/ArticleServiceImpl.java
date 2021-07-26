package com.chen.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.blog.dao.dos.Archives;
import com.chen.blog.dao.mapper.ArticleBodyMapper;
import com.chen.blog.dao.mapper.ArticleMapper;
import com.chen.blog.dao.mapper.ArticleTagMapper;
import com.chen.blog.dao.pojo.Article;
import com.chen.blog.dao.pojo.ArticleBody;
import com.chen.blog.dao.pojo.ArticleTag;
import com.chen.blog.dao.pojo.SysUser;
import com.chen.blog.service.*;
import com.chen.blog.utils.UserThreadLocal;
import com.chen.blog.vo.ArticleBodyVo;
import com.chen.blog.vo.ArticleVo;
import com.chen.blog.vo.Result;
import com.chen.blog.vo.TagVo;
import com.chen.blog.vo.params.ArticleParam;
import com.chen.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 21:55
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TagsService tagsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleTagMapper articleTagMapper;

    //
    @Override
    public Result listArticle(PageParams pageParams) {
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        IPage<Article> articleIPage = articleMapper.listArticle(
                page,
                pageParams.getCategoryId(),
                pageParams.getTagId(),
                pageParams.getYear(),
                pageParams.getMonth());
        List<Article> records = articleIPage.getRecords();
        return Result.success(copyList(records, true, true));
    }

    // 使用mybatis_plus的方式
    //@Override
    //public Result listArticle(PageParams pageParams) {
    //    //分页查询article数据库表
    //    Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
    //    LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
    //    if (pageParams.getCategoryId() != null) {
    //        queryWrapper.eq(Article::getCategoryId, pageParams.getCategoryId());
    //    }
    //    List<Long> articleIdList = new ArrayList<>();
    //    if (pageParams.getTagId() != null) {
    //        LambdaQueryWrapper<ArticleTag> articleTagLambdaQueryWrapper = new LambdaQueryWrapper<>();
    //        articleTagLambdaQueryWrapper.eq(ArticleTag::getTagId, pageParams.getTagId());
    //        List<ArticleTag> articleTags = articleTagMapper.selectList(articleTagLambdaQueryWrapper);
    //        for (ArticleTag articleTag : articleTags) {
    //            articleIdList.add(articleTag.getArticleId());
    //        }
    //        if (articleIdList.size() > 0) {
    //            queryWrapper.in(Article::getId, articleIdList);
    //        }
    //    }
    //
    //    //是否置顶进行排序
    //    queryWrapper.orderByDesc(Article::getWeight, Article::getCreateDate);
    //    Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
    //    List<Article> records = articlePage.getRecords();
    //    //不能直接返回
    //    List<ArticleVo> articleVoList = copyList(records, true, true);
    //    return Result.success(articleVoList);
    //}


    @Override
    public Result hotArticle(int limit) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        // select id,title from article order by view_counts desc limit 5
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.select(Article::getId, Article::getTitle);
        queryWrapper.last("limit " + limit);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articles, false, false));
    }

    @Override
    public Result newArticles(int limit) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        // select id,title from article order by getCreateDate desc limit 5
        queryWrapper.orderByDesc(Article::getCreateDate);
        queryWrapper.select(Article::getId, Article::getTitle);
        queryWrapper.last("limit " + limit);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articles, false, false));
    }

    @Override
    public Result listArchives() {
        List<Archives> archivesList = articleMapper.listArchives();
        return Result.success(archivesList);
    }

    @Autowired
    private ThreadService threadService;

    @Override
    public Result findArticleById(Long articleId) {
        /**
         * 1、根据id查询文章信息
         * 2、根据bodyId和categoryid去做关联查询
         */
        Article article = this.articleMapper.selectById(articleId);
        ArticleVo articleVo = copy(article, true, true, true, true);
        //更新文章阅读数，使用线程池的方法
        threadService.updateArticleViewCount(articleMapper, article);
        return Result.success(articleVo);
    }

    @Override
    public Result publish(ArticleParam articleParam) {
        //此接口要加入到登录拦截中
        SysUser sysUser = UserThreadLocal.get();
        /**
         * 1、发布文章 目的构建 Article对象
         * 2、作者id 当前的登录用户
         * 3、标签 要将标签加入到 关联列表当中
         * 4、body内容存储article bodyId
         */
        Article article = new Article();
        article.setAuthorId(sysUser.getId());
        article.setWeight(Article.Article_Common);
        article.setViewCounts(0);
        article.setTitle(articleParam.getTitle());
        article.setSummary(articleParam.getSummary());
        article.setCommentCounts(0);
        article.setCreateDate(System.currentTimeMillis());
        article.setCategoryId(Long.parseLong(articleParam.getCategory().getId()));
        //插入成功后会生成一个文章id
        this.articleMapper.insert(article);
        //tag
        List<TagVo> tags = articleParam.getTags();
        if (tags != null) {
            for (TagVo tag : tags) {
                Long articleId = article.getId();
                ArticleTag articleTag = new ArticleTag();
                articleTag.setTagId(Long.parseLong(tag.getId()));
                articleTag.setArticleId(articleId);
                articleTagMapper.insert(articleTag);
            }
        }
        //body
        ArticleBody articleBody = new ArticleBody();
        articleBody.setArticleId(article.getId());
        articleBody.setContent(articleParam.getBody().getContent());
        articleBody.setContentHtml(articleParam.getBody().getContentHtml());
        articleBodyMapper.insert(articleBody);

        article.setBodyId(articleBody.getId());
        articleMapper.updateById(article);
        Map<String, String> map = new HashMap<>();
        map.put("id", article.getId().toString());
        return Result.success(map);
    }

    private List<ArticleVo> copyList(List<Article> records, boolean isTags, boolean isAuthor) {
        ArrayList<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : records) {
            ArticleVo articleVo = copy(article, isTags, isAuthor, false, false);
            articleVoList.add(articleVo);
        }
        return articleVoList;
    }

    private List<ArticleVo> copyList(List<Article> records, boolean isTags, boolean isAuthor, boolean isBody, boolean isCategory) {
        ArrayList<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : records) {
            ArticleVo articleVo = copy(article, isTags, isAuthor, isBody, isCategory);
            articleVoList.add(articleVo);
        }
        return articleVoList;
    }

    /**
     * @param article    文章
     * @param isAuthor   是否显示作者
     * @param isTags     是否显示标签
     * @param isBody     是否显示有文章
     * @param isCategory 是否显示类别
     * @return
     */
    public ArticleVo copy(Article article, boolean isTags, boolean isAuthor, boolean isBody, boolean isCategory) {
        ArticleVo articleVo = new ArticleVo();
        articleVo.setId(String.valueOf(article.getId()));
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyy-MM-dd HH:mm"));
        //不是所有的接口都需要标签和作者信息
        if (isAuthor) {
            SysUser sysUser = sysUserService.findUserById(article.getAuthorId());
            articleVo.setAuthor(sysUser.getNickname());
        }
        if (isTags) {
            List<TagVo> tags = tagsService.findTagsByArticleId(article.getId());
            articleVo.setTags(tags);
        }
        if (isBody) {
            Long bodyId = article.getBodyId();
            articleVo.setBody(findArticleBodyById(bodyId));
        }
        if (isCategory) {
            Long categoryId = article.getCategoryId();
            articleVo.setCategory(categoryService.findCategoryById(categoryId));
        }
        return articleVo;
    }

    @Autowired
    private ArticleBodyMapper articleBodyMapper;

    private ArticleBodyVo findArticleBodyById(Long bodyId) {
        ArticleBody articleBody = articleBodyMapper.selectById(bodyId);
        ArticleBodyVo articleBodyVo = new ArticleBodyVo();
        articleBodyVo.setContent(articleBody.getContent());
        return articleBodyVo;
    }


}
