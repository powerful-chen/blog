package com.chen.blog.test;

import com.chen.blog.dao.dos.Archives;
import com.chen.blog.dao.mapper.ArticleMapper;
import com.chen.blog.service.LoginService;
import com.chen.blog.vo.params.LoginParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @ClassName tryTest
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/22 11:08
 */
@SpringBootTest
public class tryTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private LoginService loginService;

    @Test
    public void test01(){
        List<Archives> archivesList = articleMapper.listArchives();
        for (Archives archives : archivesList) {
            System.out.println(archives);
        }
    }

    @Test
    public void test02(){
        LoginParam loginParam = new LoginParam();
        loginParam.setAccount("admin1");
        loginParam.setPassword("admin1");
        loginService.login(loginParam);

    }
}
