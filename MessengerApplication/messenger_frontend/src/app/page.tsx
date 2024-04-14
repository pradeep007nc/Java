"use client";

import Image from "next/image";
import { useState } from "react";
import ChatPage from "./components/ChatPage";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <ChatPage />
    </main>
  );
}
