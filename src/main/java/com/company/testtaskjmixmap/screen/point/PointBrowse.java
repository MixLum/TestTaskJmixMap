package com.company.testtaskjmixmap.screen.point;

import io.jmix.mapsui.component.GeoMap;
import io.jmix.mapsui.component.layer.style.GeometryStyles;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.company.testtaskjmixmap.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Point.browse")
@UiDescriptor("point-browse.xml")
@LookupComponent("pointsTable")
public class PointBrowse extends StandardLookup<Point> {
    @Autowired
    private Notifications notifications;
    @Autowired
    private GeometryStyles geometryStyles;

    @Subscribe("map")
    public void onMapClick(GeoMap.ClickEvent event) {
        org.locationtech.jts.geom.Point point = event.getPoint();
        String caption = String.format("%.4f, %.4f", point.getX(), point.getY());
        notifications.create().withCaption(caption).show();

    }

    @Subscribe("createBtn")
    public void onCreateBtnClick(Button.ClickEvent event) {

    }

    @Subscribe("map")
    public void onMapMoveEnd(GeoMap.MoveEndEvent event) {

    }
}