package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    public Admin saveAdmin(Admin admin);
}
