package com.company.testtaskjmixmap.screen.point;

import io.jmix.mapsui.component.GeoMap;
import io.jmix.ui.component.Button;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.testtaskjmixmap.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("Point.edit")
@UiDescriptor("point-edit.xml")
@EditedEntityContainer("pointDc")
public class PointEdit extends StandardEditor<Point> {

    @Autowired
    private GeoMap map;
    @Autowired
    private InstanceContainer<Point> pointDc;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {

    }

    @Subscribe("commitBtn")
    public void onCommitBtnClick(Button.ClickEvent event) {

    }

    @Subscribe
    public void onInit(InitEvent event) {

    }
}