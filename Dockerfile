FROM amazonlinux:2018.03.0.20180827

COPY ./docker/binary-sbt-rpm.repo /etc/yum.repos.d/bintray-sbt-rpm.repo
RUN yum update -y && \
    yum install -y \
      java-1.8.0-openjdk-devel \
      sbt \
      curl \
      git \
      # zip \
      # unzip \
      which \
      && \
    yum clean all && \
    rm -rf /var/cache/yum/*

# COPY ./docker/binary-sbt-rpm.repo /etc/yum.repos.d/bintray-sbt-rpm.repo
# RUN yum install -y \
#       sbt \
#       && \
#     yum clean all && \
#     rm -rf /var/cache/yum/*

# COPY ./docker/install-sdkman.sh /tmp/install-sdkman.sh
# RUN /tmp/install-sdkman.sh && \
#     source /root/.sdkman/bin/sdkman-init.sh && \
#     rm -rf /tmp/install-sdkman.sh
#
# RUN sdk list java && \
#     # sdk install java 8.0.265.hs-adpt && \
#     sdk install sbt

RUN cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime
