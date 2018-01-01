package com.xie.java.api.service;

import com.xie.java.api.bo.ComposeBo;
import com.xie.java.api.bo.TestBo;
import com.xie.java.api.vo.TestVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@FeignClient(name="test-server")
public interface TestService {

    @RequestMapping("addCompose")
    boolean addCompose(@RequestBody ComposeBo bo);

    @RequestMapping("add")
    boolean add(TestBo bo);


    @RequestMapping(value = "addBatch",method = RequestMethod.POST)
    boolean addBatch(@RequestBody ArrayList<TestBo> bos);

    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    TestVo queryById(@RequestParam("id") Long id);

    @RequestMapping(value = "queryList",method = RequestMethod.GET)
    List<TestVo> queryList();
}
