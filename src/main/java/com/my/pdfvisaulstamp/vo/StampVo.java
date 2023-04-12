package com.my.pdfvisaulstamp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zzwzd
 * @create 2023-04-12 12:51
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class StampVo {
    List<PointVo> pointVoList;
    double x;
    double y;
    boolean vertical;

}
