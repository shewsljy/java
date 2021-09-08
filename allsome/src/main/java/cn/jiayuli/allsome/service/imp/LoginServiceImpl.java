package cn.jiayuli.allsome.service.imp;

import cn.jiayuli.allsome.mapper.custom.CustomGoodsMapper;
import cn.jiayuli.allsome.service.LoginService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DS("oracle")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private CustomGoodsMapper customGoodsMapper;

    @Override
    public Integer goodsCount() {
        return customGoodsMapper.goodsCount();
    }
}
