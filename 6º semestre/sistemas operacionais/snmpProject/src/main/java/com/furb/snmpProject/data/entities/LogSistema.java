package com.furb.snmpProject.data.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "LOG_SISTEMA")
public class LogSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_log")
    private Long cdLog;

    @Column(name = "ds_log", nullable = false, length = 200)
    private String dsLog;

    @Column(name = "dt_log", nullable = false, length = 30)
    private LocalDateTime dtLog;

    public LogSistema(String dsLog, LocalDateTime dtLog) {
        this.dsLog = dsLog;
        this.dtLog = dtLog;
    }

    public Long getCdLog() {
        return cdLog;
    }

    public void setCdLog(Long cdLog) {
        this.cdLog = cdLog;
    }

    public String getDsLog() {
        return dsLog;
    }

    public void setDsLog(String dsLog) { this.dsLog = dsLog; }

    public LocalDateTime getDtLog() {
        return dtLog;
    }

    public void setDtLog(LocalDateTime dtLog) {
        this.dtLog = dtLog;
    }
}
