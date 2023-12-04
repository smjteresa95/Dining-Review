package com.example.diningreview.utils;

import com.example.diningreview.service.RestaurantService;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UtilityClass
public class ValidationUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationUtils.class);

    //입력한 필드가 null 인지 아닌지 검사 하는 메서드
    public static boolean isNull(Object obj, String fieldName){
        if(obj == null){
            LOGGER.error("{} is null", fieldName);
            return true;
        }
        return false;
    }

    //알러지 점수 범위 유효성 검사
    public static boolean isValidateScore(Float score, String fieldName){
        if(score ==null){
            LOGGER.error("{} is null", fieldName);
            return false;
        }
        if(score < 0 || score >5){
            LOGGER.error("{} is out of range. Must between 0 to 5", fieldName);
            return false;
        }
        return true;
    }

}
