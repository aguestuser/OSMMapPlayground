package whereat.io.osmmapplayground;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import whereat.io.osmmapplayground.support.MyZoomButtonsController;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, shadows=MyZoomButtonsController.class)

public class MapViewManagerTest {

    @Test
    public void createMapView_should_createMapViewWithDefaultSettings() throws Exception {

        Context context = Robolectric.buildActivity(MainActivity.class).create().resume().visible().get();
        MapView map = MapViewManager.createMapView(context);
        map.layout(0, 0, 1920, 1080); // because robolectric views have dimension 0 x 0 by default

        assertThat(map).isInstanceOf(MapView.class);

        assertThat(map.getTileProvider().getTileSource()).isEqualTo(TileSourceFactory.MAPNIK);
        assertThat(map.canZoomIn()).isTrue();
        assertThat(map.canZoomOut()).isTrue();
        assertThat(map.getZoomLevel()).isEqualTo(13);
        assertThat(isWithin(map.getMapCenter().getLatitude(), 40.7447038, .0001)).isTrue();
        assertThat(isWithin(map.getMapCenter().getLongitude(), -73.9870748, .0001)).isTrue();
    }

    public boolean isWithin(double expected, double actual, double diff){
        return Math.abs(expected - actual) < diff;
    }
}