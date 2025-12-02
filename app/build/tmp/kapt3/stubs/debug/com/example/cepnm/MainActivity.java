package com.example.cepnm;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/example/cepnm/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "map", "Lorg/osmdroid/views/MapView;", "viewModel", "Lcom/example/cepnm/viewmodel/PointViewModel;", "getViewModel", "()Lcom/example/cepnm/viewmodel/PointViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "refreshMarkers", "points", "", "Lcom/example/cepnm/data/Point;", "onResume", "onPause", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private org.osmdroid.views.MapView map;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final org.osmdroid.util.GeoPoint WARSAW = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_POINT_ID = "point_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_LAT = "lat";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_LON = "lon";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.cepnm.MainActivity.Companion Companion = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.cepnm.viewmodel.PointViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void refreshMarkers(java.util.List<com.example.cepnm.data.Point> points) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/cepnm/MainActivity$Companion;", "", "<init>", "()V", "WARSAW", "Lorg/osmdroid/util/GeoPoint;", "getWARSAW", "()Lorg/osmdroid/util/GeoPoint;", "EXTRA_POINT_ID", "", "EXTRA_LAT", "EXTRA_LON", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.osmdroid.util.GeoPoint getWARSAW() {
            return null;
        }
    }
}