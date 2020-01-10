package com.neteasy.server.modules.index.service.impl;

import com.neteasy.server.modules.index.entity.IndexBusinessEntity;
import com.neteasy.server.modules.index.dao.IndexBusinessMapper;
import com.neteasy.server.modules.index.service.IndexBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neteasy.server.modules.index.vo.IndexBusinessVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页商家表  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-01-09
 */
@Service
public class IndexBusinessServiceImpl extends ServiceImpl<IndexBusinessMapper, IndexBusinessEntity> implements IndexBusinessService {

    @Override
    public List<IndexBusinessVO> listIndexBusiness() {
        return baseMapper.listIndexBusiness();
    }
}
