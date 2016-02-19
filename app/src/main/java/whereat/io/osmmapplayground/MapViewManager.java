package whereat.io.osmmapplayground;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.ResourceProxyImpl;
import org.osmdroid.views.MapView;

public class MapViewManager {

    public static MapView createMapView(Context context) {
        MapView mv = new MapView(context);

        mv.setTileSource(TileSourceFactory.MAPNIK);
        mv.setBuiltInZoomControls(true);
        mv.setMultiTouchControls(true);

        IMapController mapController = mv.getController();
        mapController.setZoom(13);
        mapController.setCenter(new GeoPoint(40.7447038, -73.9870748));

        return mv;
    }
}
