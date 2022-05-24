package com.ecar.factory;

import com.ecar.encryption.EncryUtil;

/*************************************
 * 功能：
 * 创建者： kim_tony
 * 创建日期：2017/1/18
 * 版权所有：深圳市亿车科技有限公司
 *************************************/

public interface IEncryptionUtilFactory {
    EncryUtil createEpark();//一体化
    EncryUtil creatParkFee();//宜停车
    EncryUtil createRoadPark();//路边(不包含宜停车)
    EncryUtil createRoadPda();//路边PDA
}
