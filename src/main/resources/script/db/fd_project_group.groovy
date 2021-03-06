package script.db

databaseChangeLog(logicalFilePath: 'script/db/fd_project_group.groovy') {
    changeSet(author: 'longhe1996@icloud.com', id: '2019-02-25-fd-project-group') {
        if (helper.dbType().isSupportSequence()) {
            createSequence(sequenceName: 'FD_PROJECT_GROUP_S', startValue: "1")
        }
        createTable(tableName: "FD_PROJECT_GROUP") {
            column(name: 'ID', type: 'BIGINT UNSIGNED', autoIncrement: true, remarks: '表ID，主键，供其他表做外键，unsigned bigint、单表时自增、步长为 1。') {
                constraints(primaryKey: true, primaryKeyName: 'PK_FD_PROJECT_GROUP')
            }
            column(name: 'PROJECT_ID', type: 'BIGINT UNSIGNED', remarks: '项目ID。') {
                constraints(nullable: false)
            }
            column(name: 'PARENT_ID', type: 'BIGINT UNSIGNED', remarks: '父亲ID。', defaultValue: "0") {
                constraints(nullable: false)
            }
            column(name: "START_DATE", type: "DATETIME", remarks: '开始时间')
            column(name: "END_DATE", type: "DATETIME", remarks: '结束时间')
            column(name: 'IS_ENABLED', type: 'TINYINT UNSIGNED', defaultValue: "1", remarks: '是否启用。1启用，0未启用') {
                constraints(nullable: false)
            }


            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP", remarks: "更新时间")
            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT UNSIGNED", defaultValue: "1")
            column(name: "CREATED_BY", type: "BIGINT UNSIGNED", defaultValue: "0")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT UNSIGNED", defaultValue: "0")
        }
    }
}