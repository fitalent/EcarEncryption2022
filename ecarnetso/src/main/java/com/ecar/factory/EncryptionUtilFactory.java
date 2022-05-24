package com.ecar.factory;

import com.ecar.encryption.Epark.EparkEncrypUtil;
import com.ecar.encryption.ParkFee.ParkFeeEncrypUtil;
import com.ecar.encryption.RoadPark.RoadParkEncrypUtil;
import com.ecar.encryption.RoadPda.RoadPdaEncrypUtil;
import com.ecar.util.TagUtil;

/*************************************
 * 功能： 创建工具类
 * 创建者： kim_tony
 * 创建日期：2017/1/17
 * 版权所有：深圳市亿车科技有限公司
 *************************************/

public class EncryptionUtilFactory implements IEncryptionUtilFactory {

    private static EncryptionUtilFactory encryptionUtilFactory;

    private EparkEncrypUtil eparkEncrypUtil;
    private ParkFeeEncrypUtil parkFeeEncrypUtil;
    private RoadParkEncrypUtil roadParkEncrypUtil;
    private RoadPdaEncrypUtil roadPdaEncrypUtil;


    private EncryptionUtilFactory() {
    }

     //  isPrintLog:true 打印log
    public static EncryptionUtilFactory getDefault(boolean isPrintLog) {
        TagUtil.IS_SHOW_LOG=isPrintLog;
        if (encryptionUtilFactory == null) {
            encryptionUtilFactory = new EncryptionUtilFactory();
        }
        return encryptionUtilFactory;
    }

    //一体化
    @Override
    public EparkEncrypUtil createEpark() {
        return eparkEncrypUtil == null ? eparkEncrypUtil = new EparkEncrypUtil()
                : eparkEncrypUtil;
    }

    //宜停车
    @Override
    public ParkFeeEncrypUtil creatParkFee() {
        return parkFeeEncrypUtil == null ? parkFeeEncrypUtil = new ParkFeeEncrypUtil()
                : parkFeeEncrypUtil;
    }

    //路边
    @Override
    public RoadParkEncrypUtil createRoadPark() {
        return roadParkEncrypUtil == null ? roadParkEncrypUtil = new RoadParkEncrypUtil()
                : roadParkEncrypUtil;
    }

    //路边pda
    @Override
    public RoadPdaEncrypUtil createRoadPda() {
        return roadPdaEncrypUtil == null ? roadPdaEncrypUtil = new RoadPdaEncrypUtil()
                : roadPdaEncrypUtil;
    }
}
