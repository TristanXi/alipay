package com.tristan.exam.alipay.tranfer.service.impl;

import com.tristan.exam.alipay.tranfer.TransactionManager;
import com.tristan.exam.alipay.tranfer.config.DefaultRecoverConfig;
import com.tristan.exam.alipay.tranfer.config.RecoverConfig;
import com.tristan.exam.alipay.tranfer.repository.CachableTransactionRepository;
import com.tristan.exam.alipay.tranfer.repository.TransactionRepository;
import com.tristan.exam.alipay.tranfer.service.TransactionConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: alipay
 * @description: 事务配置服务
 * @author: Tristan.Xi
 * @create: 2020-07-01 10:40
 **/
@Service
public class TransactionConfigServiceImpl implements TransactionConfigService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired(required = false)
    private RecoverConfig recoverConfig = DefaultRecoverConfig.INSTANCE;

    private static volatile ExecutorService executorService = null;

    private TransactionManager transactionManager;

    public void init() {
        transactionManager = new TransactionManager();
        transactionManager.setTransactionRepository(transactionRepository);

        if (executorService == null) {


            Executors.defaultThreadFactory();
            synchronized (TransactionConfigService.class) {

                if (executorService == null) {
                    executorService = new ThreadPoolExecutor(
                            recoverConfig.getAsyncTerminateThreadCorePoolSize(),
                            recoverConfig.getAsyncTerminateThreadMaxPoolSize(),
                            5L,
                            TimeUnit.SECONDS,
                            new ArrayBlockingQueue<Runnable>(recoverConfig.getAsyncTerminateThreadWorkQueueSize()),
                            new ThreadFactory() {

                                final AtomicInteger poolNumber = new AtomicInteger(1);
                                final ThreadGroup group;
                                final AtomicInteger threadNumber = new AtomicInteger(1);
                                final String namePrefix;

                                {
                                    SecurityManager securityManager = System.getSecurityManager();
                                    this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
                                    this.namePrefix = "tcc-async-terminate-pool-" + poolNumber.getAndIncrement() + "-thread-";
                                }

                                public Thread newThread(Runnable runnable) {
                                    Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
                                    if (thread.isDaemon()) {
                                        thread.setDaemon(false);
                                    }

                                    if (thread.getPriority() != 5) {
                                        thread.setPriority(5);
                                    }

                                    return thread;
                                }
                            },
                            new ThreadPoolExecutor.CallerRunsPolicy());
                }
            }
        }

        transactionManager.setExecutorService(executorService);

        if (transactionRepository instanceof CachableTransactionRepository) {
            ((CachableTransactionRepository) transactionRepository).setExpireDuration(recoverConfig.getRecoverDuration());
        }
    }
    @Override
    public TransactionManager getTransactionManager() {
        return null;
    }

    @Override
    public TransactionRepository getTransactionRepository() {
        return null;
    }

    @Override
    public RecoverConfig getRecoverConfig() {
        return null;
    }
}
