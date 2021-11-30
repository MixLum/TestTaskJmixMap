package com.company.testtaskjmixmap.screen.point;

import io.jmix.ui.screen.*;
import com.company.testtaskjmixmap.entity.Point;

@UiController("Point.edit")
@UiDescriptor("point-edit.xml")
@EditedEntityContainer("pointDc")
public class PointEdit extends StandardEditor<Point> {
}