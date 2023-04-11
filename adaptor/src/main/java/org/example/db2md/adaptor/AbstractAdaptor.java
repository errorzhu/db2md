package org.example.db2md.adaptor;

import org.example.db2md.model.Db2MdParameters;

/**
 * @Author pdp
 * @Date 2023/4/10 17:30
 * @PackageName:org.example.db2md.adaptor
 * @ClassName: AbstractAdaptor
 * @Description: TODO
 */
public abstract class AbstractAdaptor {

    protected final Db2MdParameters parameters;

    public AbstractAdaptor(Db2MdParameters parameters) {
        this.parameters= parameters;
    }
}
