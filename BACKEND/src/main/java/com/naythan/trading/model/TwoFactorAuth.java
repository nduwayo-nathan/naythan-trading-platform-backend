package com.naythan.trading.model;


import com.naythan.trading.domain.verificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled =false;
    private verificationType  sendTo;

}
