// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: television.proto

package com.test.models;

public interface TelevisionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Television)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string brand = 1;</code>
   */
  java.lang.String getBrand();
  /**
   * <code>string brand = 1;</code>
   */
  com.google.protobuf.ByteString
      getBrandBytes();

  /**
   * <pre>
   * year is confusing
   * </pre>
   *
   * <code>int32 model = 2;</code>
   */
  int getModel();

  /**
   * <code>.Type type = 3;</code>
   */
  int getTypeValue();
  /**
   * <code>.Type type = 3;</code>
   */
  com.test.models.Type getType();
}
