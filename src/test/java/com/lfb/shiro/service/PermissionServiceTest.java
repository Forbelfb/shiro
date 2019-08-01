package com.lfb.shiro.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {
    @Autowired
    PermissionService permissionService;
    @Test
    public void findPermission() {
        List<Integer> integers=new ArrayList<>();
        integers.add(1);
        integers.add(2);


        System.out.println(permissionService.findPermission(integers));
    }
}