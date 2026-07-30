package com.NickZhang.Mortilegion.client;

import com.NickZhang.Mortilegion.entity.DreadLord;

public class DreadlordModel extends EntityModel<DreadLord>
{
    public DreadlordModel()
    {
        super(
                "geo/dreadlord.geo.json",
                "texture/dreadlord.png",
                "animations/dreadlord.animation.json"
        );
    }
}
