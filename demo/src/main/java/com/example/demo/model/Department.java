package com.example.demo.model;

/**
 * Table: department
 */
public class Department {
    /**
     * Column: id
     */
    private Long id;

    /**
     * Column: name
     * Remark: 部门名称或下属机构名称
     */
    private String name;

    /**
     * Column: level
     * Remark: 部门级别字符串
     */
    private String level;

    /**
     * Column: parent_id
     * Remark: 父级主键id
     */
    private Long parentId;

    /**
     * Column: seq
     * Remark: 排序号
     */
    private Long seq;

    /**
     * Column: mtime
     * Remark: 更新时间
     */
    private Integer mtime;

    /**
     * Column: ctime
     * Remark: 创建时间
     */
    private Integer ctime;

    /**
     * Column: muser_id
     * Remark: 修改人
     */
    private Integer muserId;

    /**
     * Column: cuser_id
     * Remark: 创建人
     */
    private Integer cuserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Integer getMtime() {
        return mtime;
    }

    public void setMtime(Integer mtime) {
        this.mtime = mtime;
    }

    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    public Integer getMuserId() {
        return muserId;
    }

    public void setMuserId(Integer muserId) {
        this.muserId = muserId;
    }

    public Integer getCuserId() {
        return cuserId;
    }

    public void setCuserId(Integer cuserId) {
        this.cuserId = cuserId;
    }
}