# RxRetrofitMvp

## 这是一个简单易懂的封装过程，只是单纯的结合RxJava 和 Retrofit最基本的知识使用。

#### 简单的接口调用
```
    **
    * 获取省信息
    * @param listener 回调
    */
    public void getProvince(MainListener listener) {
        HttpRx.normal(getApiManager().province())
                .subscribe(new MySubscriber<List<Province>>() {
                    @Override
                    protected void onSuccess(List<Province> provinces) {
                        Logger.d(provinces);
                        listener.setProvinces(provinces);
                    }
                });
    }
```

#### HttpRx封装

```
public static <T extends Result<R>,R> Flowable<R>  normal(Flowable<T> followable) {
        return followable.subscribeOn(Schedulers.io())
                .map(new ResultFunction<>())
                .observeOn(AndroidSchedulers.mainThread());
    }
```

#### 过滤返回数据结果

```
public class ResultFunction<T extends Result<R>,R> implements Function<T,R> {

    @Override
    public R apply(T t) throws Exception {
        if (t.getCode() == 1) {
            if (t.getData() != null) {
                return t.getData();
            }
            throw new ResultException(ResultException.TYPE_CODE_SUCCESS,"data is null");
        }
        throw  new ResultException(ResultException.TYPE_CODE_FAIL,t.getMsg());
    }
}
```
