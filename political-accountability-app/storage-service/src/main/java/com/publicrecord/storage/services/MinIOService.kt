package com.publicrecord.storage.services

import io.minio.MinioClient
import io.minio.UploadObjectArgs
import io.minio.BucketExistsArgs
import io.minio.MakeBucketArgs
import io.minio.GetObjectArgs
import java.io.InputStream

class MinIOService {
    private val client = MinioClient.builder()
        .endpoint("http://localhost:9000")
        .credentials("admin", "secretpass")
        .build()

    private val bucketName = "political-media"

    init {
        ensureBucketExists()
    }

    fun startService() {
        println("✅ MinIO Service Started.")
    }

    private fun ensureBucketExists() {
        if (!client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
            client.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build())
        }
    }

    fun uploadFile(filePath: String, objectName: String) {
        client.uploadObject(
            UploadObjectArgs.builder()
                .bucket(bucketName)
                .`object`(objectName)
                .filename(filePath)
                .build()
        )
        println("File uploaded: $objectName")
    }

    fun getFile(objectName: String): InputStream {
        return client.getObject(
            GetObjectArgs.builder()
                .bucket(bucketName)
                .`object`(objectName)
                .build()
        )
    }
}
