package com.yuen.weblog.admin.model.service;

import com.yuen.weblog.admin.model.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.yuen.weblog.common.utils.Response;

public interface AdminUserService {
    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response findUserInfo();
}
