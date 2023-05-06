package com.my.pdfvisaulstamp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zzwzd
 * @create 2023-04-11 17:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class PointVo {
    double x;
    double y;
    int page;
}
