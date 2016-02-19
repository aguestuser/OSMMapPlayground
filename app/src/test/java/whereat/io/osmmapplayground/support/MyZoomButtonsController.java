package whereat.io.osmmapplayground.support;

import android.view.View;
import android.widget.ZoomButtonsController;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowZoomButtonsController;

@Implements(ZoomButtonsController.class)
public class MyZoomButtonsController extends ShadowZoomButtonsController {

    public void __constructor__(View ownerView){   }

    @Implementation
    public void setZoomInEnabled(boolean enabled) {}
    @Implementation
    public void setZoomOutEnabled(boolean enabled) {}
}