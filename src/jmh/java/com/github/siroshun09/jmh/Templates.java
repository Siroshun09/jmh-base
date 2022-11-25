package com.github.siroshun09.jmh;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

public final class Templates {

    @State(Scope.Thread)
    @Fork(1)
    @Warmup(iterations = 2, time = 1)
    @Measurement(iterations = 3, time = 1)
    public static class AverageTime {

        @Setup(Level.Iteration)
        public void prepare() {
        }

        //@Benchmark // uncomment this to enable benchmark
        @BenchmarkMode(Mode.AverageTime)
        @OutputTimeUnit(TimeUnit.NANOSECONDS)
        public String benchmark_1() {
            return "a" + "b";
        }

    }

    @State(Scope.Thread)
    @Fork(1)
    @Warmup(iterations = 2, time = 1)
    @Measurement(iterations = 3, time = 1)
    public static class Throughput {

        @Setup(Level.Iteration)
        public void prepare() {
        }

        //@Benchmark // uncomment this to enable benchmark
        @BenchmarkMode(Mode.Throughput)
        @OutputTimeUnit(TimeUnit.MILLISECONDS)
        public String benchmark_1() {
            return "a" + "b";
        }

    }
}
