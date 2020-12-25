package com.sht.shoesboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Aaron
 * @date 2020/12/19 22:41
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    public String title;

    public BigDecimal price;

    public String images;

    public String brand;

    public Boolean shelf;
}
