package com.xie.java.service.impl;

import com.alibaba.fastjson.JSON;
import com.xie.java.api.bo.ComposeBo;
import com.xie.java.api.bo.TestBo;
import com.xie.java.api.service.TestService;
import com.xie.java.api.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xieyang on 17/11/13.
 */
@RestController
public class TestServiceImpl implements TestService {


    @Autowired
    DiscoveryClient discoveryClient;


    @Override
    public boolean addCompose(@RequestBody ComposeBo bo) {
        System.out.println(JSON.toJSON(bo));
        return false;
    }

    public boolean add(TestBo bo) {
        System.out.println(JSON.toJSON(bo));
        return true;
    }

    @Override
    public boolean addBatch( ArrayList<TestBo> bos) {
        System.out.println(JSON.toJSON(bos));
        return true;
    }

    public TestVo queryById(Long id) {
        System.out.println("查询"+id);
        TestVo testVo = new TestVo();
        testVo.setName("谢洋aaaa");
        testVo.setAge(18);
        return testVo;
    }

    public List<TestVo> queryList() {

        List<TestVo> list = new ArrayList<TestVo>();
        TestVo testVo = null;
        for(int i=0 ;i<40;i++){
            testVo = new TestVo();
            testVo.setAge(i);
            testVo.setName("谢洋"+i);
            list.add(testVo);
        }
        return list;
    }
}
