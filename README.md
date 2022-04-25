# Few important commands 
# Create executable JAR
mvn clean install
# Start embedded tomcat
java -jar target/frontend-0.0.1-SNAPSHOT.jar
# Build docker image
docker build -t frontend:1.0.0 .
# Run docker image
docker run -p 8081:8081 -d --name=frontend-1 -t frontend:1.0.0
# Create pod
kubectl apply -f pod.yaml
# Get pod
kubectl get pod
# Describe pod
kubectl describe pod frontend
# To troubleshoot if any error 
kubectl get pod second-application -o yaml
# Expose pod
kubectl expose pod frontend --type=LoadBalancer --port=8080 --target-port=8080

kubectl expose pod backend --type=ClusterIP --port=8081 --target-port=8081



kubectl exec --stdin --tty my-nginx-5b56ccd65f-d6654 -- /bin/bash



curl http://backend-svc:8081/backend
kubectl exec --stdin --tty my-nginx-5b56ccd65f-d6654 -- /bin/bash
