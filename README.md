# spring-java

Servicios REST para consular y almacenar información en una base de datos postgres.



# GET 
http://localhost:8090/api/v1/products

# POST 
http://localhost:8090/api/v1/products
  
```
{
        "id": "5",
        "name": "jamon",
        "value": 800
}
```


  ## Script para la prueba
```
CREATE TABLE IF NOT EXISTS public.productos
(
   identificador             	text,
   nombre_producto             	text,
   valor                       	text,
   CONSTRAINT pk_producto PRIMARY KEY (identificador)
);

insert into public.productos values ('1','galletas', 2000);
insert into public.productos values ('2','chocolate', 6000);
insert into public.productos values ('3','queso', 5000);
insert into public.productos values ('4','pan', 1000);
```
