package com.company.testtaskjmixmap.screen.point;

import io.jmix.maps.utils.GeometryUtils;
import io.jmix.mapsui.component.CanvasLayer;
import io.jmix.mapsui.component.GeoMap;
import io.jmix.mapsui.component.PopupWindow;
import io.jmix.mapsui.component.layer.style.GeometryStyles;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.component.Table;
import io.jmix.ui.icon.JmixIcon;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.testtaskjmixmap.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@UiController("Point.browse")
@UiDescriptor("point-browse.xml")
@LookupComponent("pointsTable")
public class PointBrowse extends StandardLookup<Point> {
    @Autowired
    private Notifications notifications;
    @Autowired
    private GeometryStyles geometryStyles;
    @Autowired
    private GeoMap map;
    @Autowired
    private CollectionLoader<Point> pointsDl;
    @Autowired
    private GroupTable<Point> pointsTable;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        PopupWindow popupWindow = new PopupWindow(map.getCenter(), "Wellcome!");
        map.openPopup(popupWindow);
    }

    @Subscribe("pointsTable")
    public void onPointsTableSelection(Table.SelectionEvent<Point> event) {

        Point point = event.getSource().getSingleSelected();
        if (point != null) {
            map.setCenter(point.getLongitude(), point.getLatitude());
            PopupWindow popupWindow = new PopupWindow(map.getCenter(), point.getAddress());
            map.openPopup(popupWindow);
        }
    }

    @Subscribe("map")
    public void onMapClick(GeoMap.ClickEvent event) {
        org.locationtech.jts.geom.Point point = event.getPoint();
        if (point != null) {

        }


    }

    @Subscribe("createBtn")
    public void onCreateBtnClick(Button.ClickEvent event) {

    }

    @Subscribe("map")
    public void onMapMoveEnd(GeoMap.MoveEndEvent event) {

    }

    @Subscribe
    public void onInit(InitEvent event) {
        pointsDl.load();
        List<Point> points = pointsDl.getContainer().getItems();
        for (Point point : points) {
            CanvasLayer.Point pointWithImageIcon = addPoint(point.getLongitude(), point.getLatitude());
            pointWithImageIcon.setStyle(
                    geometryStyles.point()
                            .withImageIcon(Objects.requireNonNull(this.getClass().getClassLoader()
                                    .getResource(String.format("icons/0%1d.png", point.getIcon()))).toString())
                            .setIconSize(15, 15)
                            .setPopupAnchor(0, -17))
                    .setPopupContent(point.getAddress());
        }
    }

    private CanvasLayer.Point addPoint(double longitude, double latitude) {
        CanvasLayer canvas = map.getCanvas();
        return canvas.addPoint(GeometryUtils.createPoint(longitude, latitude))
                .setPopupContent(String.format("Point: %.2f, %.2f", longitude, latitude))
                .setEditable(true);
    }
}