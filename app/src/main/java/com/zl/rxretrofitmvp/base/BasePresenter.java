package com.zl.rxretrofitmvp.base;



/**
 * @author xiaolong
 * @ClassName BasePresenter
 * @Date 2018/6/6
 **/
public abstract class BasePresenter<M extends BaseModel,V extends IBaseView> implements IPresenter<V>{

    protected V mView;
    protected M mModel;

    @Override
    public void attachView(V mView) {
        this.mView = mView;
        if (mModel == null) mModel = createModel();
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    protected abstract M createModel();
}
