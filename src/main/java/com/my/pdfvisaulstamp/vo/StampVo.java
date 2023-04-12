package com.my.pdfvisaulstamp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zzwzd
 * @create 2023-04-12 12:51
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class StampVo {
    double x;
    double y;
    boolean isVertical;
}
