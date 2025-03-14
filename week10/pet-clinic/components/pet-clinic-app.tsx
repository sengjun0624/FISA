"use client"

import { useState } from "react"
import { Plus, ChevronLeft } from "lucide-react"
import OwnerSearch from "./owner-search"
import OwnerDetail from "./owner-detail"
import OwnerForm from "./owner-form"
import PetForm from "./pet-form"
import { Button } from "@/components/ui/button"

type View = "search" | "detail" | "new-owner" | "edit-owner" | "new-pet"

export default function PetClinicApp() {
  const [view, setView] = useState<View>("search")
  const [selectedOwnerId, setSelectedOwnerId] = useState<number | null>(null)

  const handleOwnerSelect = (id: number) => {
    setSelectedOwnerId(id)
    setView("detail")
  }

  const handleBack = () => {
    if (view === "detail" || view === "new-owner") {
      setView("search")
    } else if (view === "edit-owner" || view === "new-pet") {
      setView("detail")
    }
  }

  return (
    <div className="max-w-3xl mx-auto p-4 sm:p-6">
      <header className="mb-8">
        <div className="flex items-center justify-between">
          {view !== "search" && (
            <Button variant="ghost" size="icon" onClick={handleBack} className="rounded-full">
              <ChevronLeft className="h-5 w-5" />
            </Button>
          )}
          <h1 className="text-2xl font-bold text-[#333D4B] flex-1 text-center">
            {view === "search" && "반려동물 클리닉"}
            {view === "detail" && "소유자 상세정보"}
            {view === "new-owner" && "새 소유자 등록"}
            {view === "edit-owner" && "소유자 정보 수정"}
            {view === "new-pet" && "새 반려동물 등록"}
          </h1>
          {view === "search" && (
            <Button
              onClick={() => setView("new-owner")}
              className="rounded-full bg-[#3182F6] hover:bg-[#1b64da] text-white"
            >
              <Plus className="h-5 w-5 mr-1" />
              소유자 등록
            </Button>
          )}
          {view === "detail" && (
            <Button
              onClick={() => setView("new-pet")}
              className="rounded-full bg-[#3182F6] hover:bg-[#1b64da] text-white"
            >
              <Plus className="h-5 w-5 mr-1" />
              반려동물 등록
            </Button>
          )}
        </div>
      </header>

      <main>
        {view === "search" && <OwnerSearch onSelectOwner={handleOwnerSelect} />}

        {view === "detail" && selectedOwnerId && (
          <OwnerDetail ownerId={selectedOwnerId} onEdit={() => setView("edit-owner")} />
        )}

        {view === "new-owner" && (
          <OwnerForm
            onSuccess={(id) => {
              setSelectedOwnerId(id)
              setView("detail")
            }}
          />
        )}

        {view === "edit-owner" && selectedOwnerId && (
          <OwnerForm ownerId={selectedOwnerId} onSuccess={() => setView("detail")} />
        )}

        {view === "new-pet" && selectedOwnerId && (
          <PetForm ownerId={selectedOwnerId} onSuccess={() => setView("detail")} />
        )}
      </main>
    </div>
  )
}

