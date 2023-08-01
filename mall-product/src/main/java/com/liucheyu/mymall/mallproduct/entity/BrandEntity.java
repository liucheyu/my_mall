package com.liucheyu.mymall.mallproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.liucheyu.common.valid.AddGroup;
import com.liucheyu.common.valid.StatusValues;
import com.liucheyu.common.valid.UpdateGroup;
import com.liucheyu.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 *
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 11:04:57
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @Null(groups = {AddGroup.class}, message = "新增時id不可填入")
    @NotNull(groups = {UpdateGroup.class}, message = "修改時id不得為空")
    @TableId
    private Long brandId;
    /**
     * 品牌名
     */
    @NotBlank(message = "品牌名不得為空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 品牌logo地址
     */
    @NotBlank(message = "logo不得為空", groups = {AddGroup.class})
    @URL(message = "url不合法", groups = {AddGroup.class, UpdateGroup.class})
    private String logo;
    /**
     * 介绍
     */
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
	@Pattern(regexp = "^[0|1]$", message = "須為0或1[0-不顯示；1-顯示]", groups = {AddGroup.class, UpdateGroup.class} )
	@NotNull(groups = {AddGroup.class, UpdateStatusGroup.class} )
    @StatusValues(values = {0, 1})
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @Pattern(regexp = "^[a-zA-Z]$", message = "首字母須為a-z或A-Z", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "首字母不得為空", groups = {AddGroup.class})
    private String firstLetter;
    /**
     * 排序
     */
    @Min(value = 0, message = "必須為正整數或0", groups = {AddGroup.class, UpdateGroup.class})
    @NotNull(groups = {AddGroup.class})
    private Integer sort;

}
