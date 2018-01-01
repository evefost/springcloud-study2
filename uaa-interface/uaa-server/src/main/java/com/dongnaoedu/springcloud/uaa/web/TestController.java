package com.dongnaoedu.springcloud.uaa.web;

import com.dongnaoedu.springcloud.uaa.db.UserDomain;
import com.xie.java.api.bo.ComposeBo;
import com.xie.java.api.bo.TestBo;
import com.xie.java.api.service.TestService;
import com.xie.java.api.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xieyang on 17/11/13.
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "addCompose",method = RequestMethod.GET)
    public boolean addCompose() {
        ComposeBo testBo = new ComposeBo();
        testBo.setSchoool("学校xxxx");
        List<ComposeBo.ClassInfo> list = new ArrayList<>();
        ComposeBo.ClassInfo classInfo = new ComposeBo.ClassInfo();
        classInfo.setAge(16);
        classInfo.setName("sfsdfsdfds");

        ComposeBo.ClassInfo classInfo2 = new ComposeBo.ClassInfo();
        classInfo2.setAge(18);
        classInfo2.setName("66666666");
        list.add(classInfo);
        list.add(classInfo2);
        testBo.setClassInfoList(list);
        return testService.addCompose(testBo);
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public boolean add() {
        TestBo testBo = new TestBo();
        testBo.setName("老洋");
        testBo.setAge(100);
        return testService.add(testBo);
    }

    @RequestMapping(value = "addBatch",method = RequestMethod.GET)
    public boolean addBatch() {
        TestBo testBo = null;
        ArrayList<TestBo> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            testBo = new TestBo();
            testBo.setName("老洋"+i);
            testBo.setAge(i);
            list.add(testBo);
        }

        return testService.addBatch(list);
    }

    @RequestMapping(value = "queryById",method = RequestMethod.GET)
    public TestVo queryById(Long id) {
        TestVo testVo1 = testService.queryById(id);
        return testVo1;
    }

    @RequestMapping(value = "queryList",method = RequestMethod.GET)
    public List<TestVo>  queryList() {
        List<TestVo> testVos = testService.queryList();
        return testVos;
    }
}
