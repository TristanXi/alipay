//package com.tristan.exam.alipay.tranfer.service;
//
//import com.tristan.exam.alipay.tranfer.model.UserAccountInfo;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @program: alipay
// * @description: 账号相关服务
// * @author: Tristan.Xi
// * @create: 2020-06-30 22:36
// **/
//@Service
//public interface AccountService {
//
//    /**
//     * 获取账户信息
//     * @param account
//     * @return
//     */
//    UserAccountInfo get(Account account);
//
//
//    /**
//     * 转账
//     * @param fromUid
//     * @param toUid
//     * @param amount
//     * @param transNum
//     * @param btype
//     * @param desc
//     * @return
//     */
//    List<TransactionRecordDTO> transfer(long fromUid, long toUid, long amount, String transNum, BusinessType btype, String desc);
//
//    /**
//     * 冻结
//     * @param uid
//     * @param amount
//     * @param transNum
//     * @param btype
//     * @param desc
//     * @return
//     */
//    List<TransactionRecordDTO> froze(long uid, long amount, String transNum, BusinessType btype, String desc);
//
//    /**
//     * 解冻
//     * @param srcTransNum
//     * @param amount
//     * @param toUid
//     * @param transNum
//     * @param btype
//     * @param desc
//     * @return
//     */
//    List<TransactionRecordDTO> unfroze(String srcTransNum, long amount, long toUid, String transNum, BusinessType btype, String desc);
//
//
//    /**
//     * 转账
//     * @param from
//     * @param to
//     * @param amount
//     * @param transNum
//     * @param btype
//     * @param desc
//     * @return
//     */
//    List<TransactionRecordDTO> transfer(Account from, Account to, long amount, String transNum, BusinessType btype, String desc);
//
//
//
//}
