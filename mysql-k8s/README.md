Mysql 8.0 deployment to k8s cluster. DB instance will be available on 30306 port (deployment type is NodePort).

# Deployment

Run commands sequentially, entering password where asked:

```
export NAMESPACE=preprod
PASSWD=$(openssl rand -base64 32)
echo "DB password: $PASSWD"
kubectl create -n $NAMESPACE secret generic dbinstance \
--from-literal=root=$PASSWD \
--type=preprod/dbcredentials

kubectl apply -n $NAMESPACE  -f dbinstance/k8s/$NAMESPACE/dbinstance-volume-1.yaml
kubectl apply -n $NAMESPACE  -f dbinstance/k8s/$NAMESPACE/dbinstance-deployment.yaml

mysql -p < "dbinstance/ddl/1-init.sql"

PASSWD=$(openssl rand -base64 32)
echo "DB password: $PASSWD"
echo "service-user password: $PASSWD"
echo "SET PASSWORD FOR 'service-user'@'%' = '$PASSWD';" | mysql -p

mysql -p < "dbinstance/ddl/2-create tables.sql"
```
