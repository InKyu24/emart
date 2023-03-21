# Spring Boot REST API
이마트24 API Documentation

## Version: 1.0.0

### /carts/add

#### POST
##### Summary:

장바구니 상품 추가

##### Description:

장바구니 내 상품 추가(동일 상품 존재 시, 자동으로 수량 증가)

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| cartDTO | body | cartDTO | Yes | [CartDTO](#CartDTO) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Carts](#Carts) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /carts/all

#### GET
##### Summary:

장바구니 상품 리스트 조회

##### Description:

userId를 이용해 장바구니 내 상품 리스트 조회

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| userId | query | userId | Yes | long |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ [Products](#Products) ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /carts/delete/{id}

#### DELETE
##### Summary:

장바구니 내 특정 상품 삭제

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 204 | No Content |
| 401 | Unauthorized |
| 403 | Forbidden |

### /carts/update/{id}

#### PATCH
##### Summary:

장바구니 수량 변경

##### Description:

장바구니 상품 수량 증가 또는 감소

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| cartDTO | body | cartDTO | Yes | [CartDTO](#CartDTO) |
| id | path | id | Yes | long |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Carts](#Carts) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /events/all

#### GET
##### Summary:

전체 이벤트 리스트 조회

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ [Events](#Events) ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /events/{id}

#### GET
##### Summary:

특정 이벤트 내 상품 리스트 조회

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ [Products](#Products) ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /products/all

#### GET
##### Summary:

전체 상품 리스트 조회

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ [Products](#Products) ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /products/search

#### GET
##### Summary:

특정 상품 이름으로 검색

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| q | query | q | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [ [Products](#Products) ] |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /products/{id}

#### GET
##### Summary:

특정 상품 상세 조회

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Products](#Products) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /users

#### GET
##### Summary:

Email을 통한 사용자 조회

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| email | query | email | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Users](#Users) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /users/add

#### POST
##### Summary:

회원가입

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| userDTO | body | userDTO | Yes | [UserDTO](#UserDTO) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Users](#Users) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /users/{id}

#### GET
##### Summary:

Id를 통한 사용자 조회

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Users](#Users) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

#### PATCH
##### Summary:

Id를 통한 사용자 정보 변경

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |
| userDTO | body | userDTO | Yes | [UserDTO](#UserDTO) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Users](#Users) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### Models


#### CartDTO

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| productId | long |  | No |
| qty | long |  | No |
| userId | long |  | No |

#### Carts

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | long |  | No |
| products | [Products](#Products) |  | No |
| qty | long |  | No |
| users | [Users](#Users) |  | No |

#### Events

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | long |  | No |
| name | string |  | No |

#### Products

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| brand | string |  | No |
| category | string |  | No |
| description | string |  | No |
| discount | double |  | No |
| id | long |  | No |
| name | string |  | No |
| price | long |  | No |
| rating | double |  | No |
| thumbnail | string |  | No |

#### UserDTO

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| email | string |  | No |
| name | string |  | No |
| password | string |  | No |

#### Users

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| email | string |  | No |
| id | long |  | No |
| name | string |  | No |
| password | string |  | No |