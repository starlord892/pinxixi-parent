package cn.itsource.pinxixi.service.impl;

import cn.itsource.pinxixi.domain.Product;
import cn.itsource.pinxixi.mapper.ProductMapper;
import cn.itsource.pinxixi.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author starlord892
 * @since 2019-05-16
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
