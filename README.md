# Tlians Web Management 系统

该项目是一个基于 Spring Boot 的后台管理系统，采用多模块 Maven 工程设计，结构清晰，功能分层明确。适用于企业级管理系统构建、权限验证、操作日志审计、部门与员工信息维护等场景。

---

## 项目结构

```
tlians_web_management_mvc/
├── tlians_parent/                  # 父模块（聚合工程）
├── tlias-pojo/                    # 实体类模块，定义 Dept、Emp、Result 等
├── tlias-web_management/          # 核心业务模块，包含 controller、service、mapper、aop、config 等
├── tlias-utils/                   # 工具模块，包含 JWT 工具类、阿里云 OSS 工具类等
├── docs/nginx-1.22.0-tlias/       # 内嵌 nginx 目录用于静态资源托管
```

---

## 功能概述

| 模块               | 功能说明                                                                 |
|--------------------|--------------------------------------------------------------------------|
| 员工管理           | 支持员工信息的增删改查，分页查询，状态控制                             |
| 部门管理           | 实现部门信息的维护、列表展示与操作权限控制                             |
| 登录认证           | 基于 JWT 实现的用户登录、权限验证及拦截器检查                           |
| 操作日志记录       | 使用自定义注解 + AOP 切面自动记录关键业务操作日志                     |
| 文件上传           | 支持文件上传接口（如员工头像），并集成阿里 OSS 作为云存储后端         |
| 异常统一处理       | 全局异常捕获机制，返回统一错误响应结构                                  |
| 权限拦截过滤器     | 自定义过滤器与拦截器联合校验用户是否已登录                             |

---

## 🔧 技术栈

- **开发框架**：Spring Boot
- **数据库访问**：MyBatis + MySQL
- **安全认证**：JWT + 拦截器 + 自定义过滤器
- **日志管理**：Spring AOP + 注解方式日志埋点
- **静态资源代理**：内嵌 Nginx 服务
- **构建工具**：Maven 多模块结构

---

## 📦 快速启动

### 1. 环境准备

- JDK 8+
- Maven 3.6+
- MySQL 5.7+
- Redis（可选，用于增强登录态）

### 2. 初始化数据库

使用 `resources` 目录中提供的 SQL 脚本初始化数据库表结构（如 `emp`, `dept`, `operate_log` 等）。

### 3. 修改配置文件

在 `application.yml` 中配置你的数据库连接信息、JWT 密钥、OSS 相关配置等。

### 4. 启动项目

```bash
# 进入主模块
cd tlians_web_management
mvn spring-boot:run
```

---

## 🧩 模块说明

### tlias-pojo

- 实体类定义：Dept、Emp、OperateLog、Result、PageBean 等
- 提供跨模块通用数据结构

### tlias-web_management

- 控制器层：处理 Web 请求，如 `DeptController`, `EmpController`, `LoginController`
- 服务层：核心业务逻辑处理
- 持久层：MyBatis Mapper 接口
- AOP 层：日志切面、注解解析等
- 配置层：Web 配置、拦截器注册
- 异常处理与登录验证统一封装

### tlias-utils

- JWT 工具类：签发与解析 Token
- 阿里云 OSS 工具：实现图片文件上传
- 通用工具方法封装

