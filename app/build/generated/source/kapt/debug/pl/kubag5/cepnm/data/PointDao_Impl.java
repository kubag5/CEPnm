package pl.kubag5.cepnm.data;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.Long;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class PointDao_Impl implements PointDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Point> __insertAdapterOfPoint;

  private final EntityDeleteOrUpdateAdapter<Point> __deleteAdapterOfPoint;

  private final EntityDeleteOrUpdateAdapter<Point> __updateAdapterOfPoint;

  public PointDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfPoint = new EntityInsertAdapter<Point>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `points` (`id`,`title`,`description`,`lat`,`lon`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Point entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getDescription());
        }
        statement.bindDouble(4, entity.getLat());
        statement.bindDouble(5, entity.getLon());
        statement.bindLong(6, entity.getCreatedAt());
      }
    };
    this.__deleteAdapterOfPoint = new EntityDeleteOrUpdateAdapter<Point>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `points` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Point entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfPoint = new EntityDeleteOrUpdateAdapter<Point>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `points` SET `id` = ?,`title` = ?,`description` = ?,`lat` = ?,`lon` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Point entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getDescription());
        }
        statement.bindDouble(4, entity.getLat());
        statement.bindDouble(5, entity.getLon());
        statement.bindLong(6, entity.getCreatedAt());
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Point point, final Continuation<? super Long> $completion) {
    if (point == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      return __insertAdapterOfPoint.insertAndReturnId(_connection, point);
    }, $completion);
  }

  @Override
  public Object delete(final Point point, final Continuation<? super Unit> $completion) {
    if (point == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __deleteAdapterOfPoint.handle(_connection, point);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object update(final Point point, final Continuation<? super Unit> $completion) {
    if (point == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __updateAdapterOfPoint.handle(_connection, point);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<Point>> getAll() {
    final String _sql = "SELECT * FROM points";
    return FlowUtil.createFlow(__db, false, new String[] {"points"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfLat = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lat");
        final int _columnIndexOfLon = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lon");
        final int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
        final List<Point> _result = new ArrayList<Point>();
        while (_stmt.step()) {
          final Point _item;
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final double _tmpLat;
          _tmpLat = _stmt.getDouble(_columnIndexOfLat);
          final double _tmpLon;
          _tmpLon = _stmt.getDouble(_columnIndexOfLon);
          final long _tmpCreatedAt;
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
          _item = new Point(_tmpId,_tmpTitle,_tmpDescription,_tmpLat,_tmpLon,_tmpCreatedAt);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object getById(final long id, final Continuation<? super Point> $completion) {
    final String _sql = "SELECT * FROM points WHERE id = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfLat = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lat");
        final int _columnIndexOfLon = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lon");
        final int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
        final Point _result;
        if (_stmt.step()) {
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final double _tmpLat;
          _tmpLat = _stmt.getDouble(_columnIndexOfLat);
          final double _tmpLon;
          _tmpLon = _stmt.getDouble(_columnIndexOfLon);
          final long _tmpCreatedAt;
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
          _result = new Point(_tmpId,_tmpTitle,_tmpDescription,_tmpLat,_tmpLon,_tmpCreatedAt);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
