package com.amaranth10.cr.util;

import com.amaranth10.backendcommon.util.redis.JedisInfoClient;

import javax.sql.DataSource;
import java.sql.Connection;

public class HealthCheckHelper {

    /**
     * 데이터 베이스 접근 유무
     */
    public static boolean isDbIsConnect(DataSource source) {

        try (Connection con = source.getConnection()) {
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    /**
     * Redis 접속 확인
     */
    public static boolean isRedisIsConnect(JedisInfoClient monitorDbObj) {
        return monitorDbObj.redisHealthCheck();
    }
// 필요시 주석 제거 (ES/MQTT 사용 모듈은 주석 제거)
//  /**
//   * ElasticSearch 접속 확인
//   * @param client RestHighLevelClient 클라이언트
//   * @return
//   */
//  public static boolean isElasticIsConnect(RestHighLevelClient client) {
//      try {
//          return client.ping(RequestOptions.DEFAULT);
//      } catch (Exception e) {
//          return false;
//      }
//  }
//
//  /**
//   *  Mqtt접속 확인
//   * @param check
//   * @return
//   */
//  public static boolean isMqttIsConnect(MqttClient check) {
//      try {
//          return check.isConnected();
//      } catch (Exception e) {
//          return false;
//      }
//  }
}