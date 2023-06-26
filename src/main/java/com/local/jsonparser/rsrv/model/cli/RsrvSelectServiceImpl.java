package com.local.jsonparser.rsrv.model.cli;

public class RsrvSelectServiceImpl implements RsrvSelectService {
    private final RsrvSelect rsrvSelect;

    public RsrvSelectServiceImpl(RsrvSelect rsrvSelect) {
        this.rsrvSelect = rsrvSelect;
    }

    @Override
    public int serviceSelect() {
        int select = rsrvSelect.selectService();
        return select;
    }
}
