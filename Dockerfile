FROM amazonlinux:2018.03.0.20180827

COPY ./docker/binary-sbt-rpm.repo /etc/yum.repos.d/bintray-sbt-rpm.repo
RUN yum update -y && \
    yum install -y \
      java-1.8.0-openjdk-devel \
      sbt \
      curl \
      git \
      which \
      && \
    yum clean all && \
    rm -rf /var/cache/yum/*

RUN cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime
