package com.neteasy.server.modules.index.service;

import com.neteasy.server.modules.index.entity.IndexBusinessEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neteasy.server.modules.index.vo.IndexBusinessVO;

import java.util.List;

/**
 * <p>
 * 首页商家表  服务类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-09
 */
public interface IndexBusinessService extends IService<IndexBusinessEntity> {

    /**
     * 获取首页合作商家
     *
     * @return
     */
    List<IndexBusinessVO> listIndexBusiness();

}
