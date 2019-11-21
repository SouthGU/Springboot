package com.sise.springbootcoursedesign.server;

import com.sise.springbootcoursedesign.dao.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/21/23:45
 * @Description:
 */
@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public int countAllByIdAndPassword(int id,String password){
        int i = adminRepository.countAllByIdAndPassword(id,password);
        return i;
    }
}
